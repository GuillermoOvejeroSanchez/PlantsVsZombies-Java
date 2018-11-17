package elems;

public class Petacereza extends Plant {
	final static int COST = 50;
	final static int CICLOS = 2;
	final static int FREC = 0;
	final static int DMG = 10;
	final static int RES = 2;
	final static String INFONAME = "Peta[c]ereza";
	final static String NAME = "petacereza";
	final static String SHORTNA = "c";

	public Petacereza() {
		super(RES, FREC, DMG, NAME, SHORTNA, COST, CICLOS);
	}

}
