package edu.umkc.wow.Control;

import edu.umkc.wow.Pl1.IPL1Imp;
import edu.umkc.wow.Pl1.Pl1Arch;
import edu.umkc.wow.Pl1.Pl1Imp;
import edu.umkc.wow.Pl2.*;

public class ControlImp implements IControlImp {
	private ControlArch _arch;
	Pl1Imp _myimp = new Pl1Imp();
	Pl2Imp _my1imp = new Pl2Imp();

	public ControlImp() {
	}

	public void setArch(ControlArch arch) {
		_arch = arch;
	}

	public ControlArch getArch() {
		return _arch;
	}

	/*
	 * Myx Lifecycle Methods: these methods are called automatically by the
	 * framework as the bricks are created, attached, detached, and destroyed
	 * respectively.
	 */
	public void init() {
		// TODO Auto-generated method stub

	}

	public void begin() {
		// TODO Auto-generated method stub
		System.out.println("Inside begin function");
		callgame();
	}

	public void end() {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/*
	 * Implementation primitives required by the architecture
	 */

	public void callgame() {
		// TODO Auto-generated method stub
		// Tetris newTetris = new Tetris();
		System.out.println("Inside CallGame function");
		Thread t1 = new Thread("player1") {
			public void run() {
				_myimp.start_mygame();
			}
		};

		Thread t2 = new Thread("player2") {
			public void run() {
				_my1imp.start_mygame();
			}
		};

		t1.start();
		try {
			t1.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		System.out.println("Inside CallGame function");
		// _myimp.start_mygame();
		// _my1imp.start_mygame();
		// Pl1Imp.start_mygame();
	}

}
