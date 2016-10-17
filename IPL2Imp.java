package edu.umkc.wow.Pl2;


import edu.umkc.wow.Pl2.Pl2Arch;

public interface IPL2Imp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (Pl2Arch arch);
	public Pl2Arch getArch();
	
	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init();	
	public void begin();
	public void end();
	public void destroy();

	/*
  	  Implementation primitives required by the architecture
	*/
  
    
    public void setCyclesPerSecond (float cyclesPerSecond)  ;        
    public void reset ()  ;        
    public void update ()  ;        
    public void Clock1 (float cyclesPerSecond)  ;        
    public void setPaused (boolean paused)  ;        
    public boolean isPaused ()  ;        
    public boolean hasElapsedCycle ()  ;        
    public boolean peekElapsedCycle ()  ;        
    public long getCurrentTime ()  ;        
    public void start_mygame ()  ;        
}