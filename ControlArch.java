package edu.umkc.wow.Control;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.wow.IClock;
import edu.umkc.wow.IGame;
import edu.umkc.wow.Pl1.Pl1Arch;

public class ControlArch extends AbstractMyxSimpleBrick implements IGame
{
    public static final IMyxName msg_IGame = MyxUtils.createName("edu.umkc.wow.IGame");
    public static final IMyxName msg_IClock = MyxUtils.createName("edu.umkc.wow.IClock");

    public IClock OUT_IClock;
    public ControlArch _arch2;  
	private IControlImp _imp;

    public ControlArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IControlImp getImplementation(){
        try{
			return new ControlImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
    	System.out.println("Inside begin Arch Begin"); 
        OUT_IClock = (IClock) MyxUtils.getFirstRequiredServiceObject(this,msg_IClock);
        if (OUT_IClock == null){
        	System.out.println("Inside NOT FOUND function");
 			System.err.println("Error: Interface edu.umkc.wow.IClock returned null");
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
		if (arg0.equals(msg_IGame)){
			return this;
		}        
		return null;
	}
  
    
    public void callgame ()   {
		_imp.callgame();
    }    
}