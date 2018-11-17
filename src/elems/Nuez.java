package elems;

public class Nuez extends Plant {
	final static int COST = 50;
	final static int CICLOS = 0;
	final static int FREC = 0;
	final static int DMG = 0;
	final static int RES = 10;
	final static String INFONAME = "[N]uez";
	final static String NAME = "nuez";
	final static String SHORTNA = "N";

	public Nuez() {
		super(RES, FREC, DMG, NAME, SHORTNA, COST, CICLOS);
	}
}
