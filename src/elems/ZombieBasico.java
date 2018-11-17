package elems;

public class ZombieBasico extends Zombie {

	final static int COST = 50;
	final static int CICLOS = 0;
	final static int FREC = 2;
	final static int DMG = 1;
	final static int RES = 5;
	final static String INFONAME = "[Z]ombie";
	final static String NAME = "zombie";
	final static String SHORTNA = "Z";

	public ZombieBasico() {
		super(RES, FREC, DMG, NAME, SHORTNA);
	}


}
