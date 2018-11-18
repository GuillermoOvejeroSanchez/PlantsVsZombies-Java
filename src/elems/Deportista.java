package elems;

public class Deportista extends Zombie {
	final static int FREC = 1;
	final static int DMG = 1;
	final static int RES = 2;
	final static String NAME = "deportista";
	final static String INFONAME = "[D]eportista";
	final static String SHORTNA = "D";

	public Deportista(int x, int y) {
		super(x, y, RES, DMG, FREC, INFONAME, SHORTNA);
	}

	public Deportista() {
		super(-1, -1, RES, DMG, FREC, INFONAME, SHORTNA);
	}
	
	public Zombie inPosition(int x, int y) {
		Zombie zombie = new Deportista(x,y);
		return zombie;
	}

}
