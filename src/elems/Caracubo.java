package elems;

public class Caracubo extends Zombie {
	final static int FREC = 4;
	final static int DMG = 1;
	final static int RES = 8;
	final static String NAME = "caracubo";
	final static String INFONAME = "[C]aracubo";
	final static String SHORTNA = "W";

	public Caracubo(int x, int y) {
		super(x, y, RES, DMG, FREC, INFONAME, SHORTNA);
	}

	public Caracubo() {
		super(-1, -1, RES, DMG, FREC, INFONAME, SHORTNA);
	}

	public Zombie inPosition(int x, int y) {
		Zombie zombie = new Caracubo(x, y);
		return zombie;
	}
}
