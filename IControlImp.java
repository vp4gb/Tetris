package edu.umkc.wow.Control;


import edu.umkc.wow.Control.ControlArch;
import edu.umkc.wow.Pl1.Pl1Arch;

public interface IControlImp 
{

	/*
	  Getter and Setter of architecture reference
	*/
    public void setArch (ControlArch arch);
	public ControlArch getArch();
	
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
  
    
    public void callgame ()  ;        
}