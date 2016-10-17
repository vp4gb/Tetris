package edu.umkc.wow.Pl1;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.wow.IClock;
import edu.umkc.wow.IGame;
import edu.umkc.wow.Control.ControlImp;
import edu.umkc.wow.Control.IControlImp;

public class Pl1Arch extends AbstractMyxSimpleBrick implements IClock
{
    public static final IMyxName msg_IClock = MyxUtils.createName("edu.umkc.wow.IClock");
    public static final IMyxName msg_IGame = MyxUtils.createName("edu.umkc.wow.IGame");

    public IGame OUT_IGame;

	private IPL1Imp _imp;

    public Pl1Arch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IPL1Imp getImplementation(){
        try{
			return new Pl1Imp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_IGame = (IGame) MyxUtils.getFirstRequiredServiceObject(this,msg_IGame);
        if (OUT_IGame == null){
 			System.err.println("Error: Interface edu.umkc.wow.IGame returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_IClock)){
			return this;
		}        
		return null;
	}
  
    
    public void setCyclesPerSecond (float cyclesPerSecond)   {
		_imp.setCyclesPerSecond(cyclesPerSecond);
    }    
    public void reset ()   {
		_imp.reset();
    }    
    public void update ()   {
		_imp.update();
    }    
    public void Clock1 (float cyclesPerSecond)   {
		_imp.Clock1(cyclesPerSecond);
    }    
    public void setPaused (boolean paused)   {
		_imp.setPaused(paused);
    }    
    public boolean isPaused ()   {
		return _imp.isPaused();
    }    
    public boolean hasElapsedCycle ()   {
		return _imp.hasElapsedCycle();
    }    
    public boolean peekElapsedCycle ()   {
		return _imp.peekElapsedCycle();
    }    
    public long getCurrentTime ()   {
		return _imp.getCurrentTime();
    }    
    public void start_mygame ()   {
		_imp.start_mygame();
    }    
}