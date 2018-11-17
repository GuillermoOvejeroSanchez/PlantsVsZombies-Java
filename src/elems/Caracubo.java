package elems;

public class Caracubo extends Zombie {
	final static int CICLOS = 4;
	final static int FREC = 4;
	final static int DMG = 1;
	final static int RES = 8;
	final static String NAME = "caracubo";
	final static String INFONAME = "[C]aracubo";
	final static String SHORTNA = "W"; 

	public Caracubo() {
		super(RES, FREC, DMG, NAME, SHORTNA);
	}


}
