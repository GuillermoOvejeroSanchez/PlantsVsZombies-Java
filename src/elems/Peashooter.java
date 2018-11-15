package elems;

public class Peashooter extends Plant {
	final static int COST = 50;
	final static int CICLOS = 1;
	final static int FREC = 1;
	final static int DMG = 1;
	final static int RES = 3;
	final static String NAME = "[P]eashooter";
	
	public Peashooter() {
		super(RES, FREC, DMG, NAME, COST, CICLOS);
	}



}
