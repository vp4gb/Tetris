package edu.umkc.wow.Pl1;


public class Pl1Imp implements IPL1Imp
{
	private Pl1Arch _arch;

    public Pl1Imp (){
    }

	public void setArch(Pl1Arch arch){
		_arch = arch;
	}
	public Pl1Arch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    //TODO Auto-generated method stub
	}
	public void begin(){
		//TODO Auto-generated method stub
		//System.out.println("In IPL1 begin");
		//_arch.OUT_IGame.callgame();
	}
	public void end(){
		//TODO Auto-generated method stub
	}
	public void destroy(){
		//TODO Auto-generated method stub
	}

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
	/**
	 * The number of milliseconds that make up one cycle.
	 */
	private float millisPerCycle;
	
	/**
	 * The last time that the clock was updated (used for calculating the
	 * delta time).
	 */
	private long lastUpdate;
	
	/**
	 * The number of cycles that have elapsed and have not yet been polled.
	 */
	private int elapsedCycles;
	
	/**
	 * The amount of excess time towards the next elapsed cycle.
	 */
	private float excessCycles;
	
	/**
	 * Whether or not the clock is paused.
	 */
	private boolean isPaused;
	
	/**
	 * Creates a new clock and sets it's cycles-per-second.
	 * @param cyclesPerSecond The number of cycles that elapse per second.
	 */
	public Pl1Imp(float cyclesPerSecond) {
		setCyclesPerSecond(cyclesPerSecond);
		reset();
	}
	
	/**
	 * Sets the number of cycles that elapse per second.
	 * @param cyclesPerSecond The number of cycles per second.
	 */
	public void setCyclesPerSecond(float cyclesPerSecond) {
		this.millisPerCycle = (1.0f / cyclesPerSecond) * 1000;
	}
	
	/**
	 * Resets the clock stats. Elapsed cycles and cycle excess will be reset
	 * to 0, the last update time will be reset to the current time, and the
	 * paused flag will be set to false.
	 */
	public void reset() {
		this.elapsedCycles = 0;
		this.excessCycles = 0.0f;
		this.lastUpdate = getCurrentTime();
		this.isPaused = false;
	}
	
	/**
	 * Updates the clock stats. The number of elapsed cycles, as well as the
	 * cycle excess will be calculated only if the clock is not paused. This
	 * method should be called every frame even when paused to prevent any
	 * nasty surprises with the delta time.
	 */
	public void update() {
		//Get the current time and calculate the delta time.
		long currUpdate = getCurrentTime();
		float delta = (float)(currUpdate - lastUpdate) + excessCycles;
		
		//Update the number of elapsed and excess ticks if we're not paused.
		if(!isPaused) {
			this.elapsedCycles += (int)Math.floor(delta / millisPerCycle);
			this.excessCycles = delta % millisPerCycle;
		}
		
		//Set the last update time for the next update cycle.
		this.lastUpdate = currUpdate;
	}
	
	/**
	 * Pauses or unpauses the clock. While paused, a clock will not update
	 * elapsed cycles or cycle excess, though the {@code update} method should
	 * still be called every frame to prevent issues.
	 * @param paused Whether or not to pause this clock.
	 */
	public void setPaused(boolean paused) {
		this.isPaused = paused;
	}
	
	/**
	 * Checks to see if the clock is currently paused.
	 * @return Whether or not this clock is paused.
	 */
	public boolean isPaused() {
		return isPaused;
	}
	
	/**
	 * Checks to see if a cycle has elapsed for this clock yet. If so,
	 * the number of elapsed cycles will be decremented by one.
	 * @return Whether or not a cycle has elapsed.
	 * @see peekElapsedCycle
	 */
	public boolean hasElapsedCycle() {
		if(elapsedCycles > 0) {
			this.elapsedCycles--;
			return true;
		}
		return false;
	}
	
	/**
	 * Checks to see if a cycle has elapsed for this clock yet. Unlike
	 * {@code hasElapsedCycle}, the number of cycles will not be decremented
	 * if the number of elapsed cycles is greater than 0.
	 * @return Whether or not a cycle has elapsed.
	 * @see hasElapsedCycle
	 */
	public boolean peekElapsedCycle() {
		return (elapsedCycles > 0);
	}
	
	/**
	 * Calculates the current time in milliseconds using the computer's high
	 * resolution clock. This is much more reliable than
	 * {@code System.getCurrentTimeMillis()}, and quicker than
	 * {@code System.nanoTime()}.
	 * @return The current time in milliseconds.
	 */
	public final long getCurrentTime() {
		return (System.nanoTime() / 1000000L);
	}

    public void start_mygame ()   {
		//TODO Auto-generated method stub
    	System.out.println("In PIL1 Start game");
    	Tetris tetris = new Tetris();
    	tetris.startGame();
    }

	@Override
	public void Clock1(float cyclesPerSecond) {
		// TODO Auto-generated method stub
		
	}
}