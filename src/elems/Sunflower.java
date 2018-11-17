package elems;

public class Sunflower extends Plant {

	final static int COST = 20;
	final static int CICLOS = 0;
	final static int FREC = 1;
	final static int DMG = 0;
	final static int RES = 1;
	final static String INFONAME = "[S]unflower";
	final static String NAME = "sunflower";
	final static String SHORTNA = "s"; 

	public Sunflower() {
		super(RES, FREC, DMG, NAME, SHORTNA, COST, CICLOS);
	}

}
