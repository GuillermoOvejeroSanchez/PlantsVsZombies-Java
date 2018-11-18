package elems;

public class ZombieBasico extends Zombie {

	final static int COST = 50;
	final static int CICLOS = 2;
	final static int FREC = 2;
	final static int DMG = 1;
	final static int RES = 5;
	final static String INFONAME = "[Z]ombie";
	final static String NAME = "zombie";
	final static String SHORTNA = "Z";

	public ZombieBasico(int x, int y) {
		super(x, y, RES, DMG, FREC, INFONAME, SHORTNA);
	}

	public ZombieBasico() {
		super(-1, -1, RES, DMG, FREC, INFONAME, SHORTNA);
	}

	public Zombie inPosition(int x, int y) {
		Zombie zombie = new ZombieBasico(x,y);
		return zombie;
	}

}
