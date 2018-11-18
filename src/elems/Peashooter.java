package elems;

public class Peashooter extends Plant {
	final static int COST = 50;
	final static int CICLOS = 1;
	final static int DMG = 1;
	final static int RES = 3;
	final static String INFONAME = "[P]eashooter";
	final static String NAME = "peashooter";
	final static String SHORTNA = "p";

	public Peashooter(int x, int y) {
		super(x, y, RES, DMG, CICLOS, NAME, SHORTNA, COST);
	}

	public Peashooter() {
		super(-1, -1, RES, DMG, CICLOS, INFONAME, SHORTNA, COST);
	}

	@Override
	public Plant parse(String plantName, int x, int y) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NAME) || plantName.equalsIgnoreCase(SHORTNA)) {
			p = new Peashooter(x, y);
		}
		return p;
	}

	//Dispara
	public void accion() {

	}
}
