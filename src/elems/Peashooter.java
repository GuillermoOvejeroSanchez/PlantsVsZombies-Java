package elems;

public class Peashooter extends Plant {
	final static int COST = 50;
	final static int CICLOS = 1;
	final static int FREC = 1;
	final static int DMG = 1;
	final static int RES = 3;
	final static String INFONAME = "[P]eashooter";
	final static String NAME = "peashooter";
	final static String SHORTNA = "p";

	public Peashooter() {
		super(RES, FREC, DMG, NAME, SHORTNA, COST, CICLOS);
	}

}
