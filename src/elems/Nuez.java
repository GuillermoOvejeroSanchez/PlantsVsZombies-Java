package elems;

public class Nuez extends Plant {
	final static int COST = 50;
	final static int CICLOS = 0;
	final static int DMG = 0;
	final static int RES = 10;
	final static String INFONAME = "[N]uez";
	final static String NAME = "nuez";
	final static String SHORTNA = "N";

	public Nuez(int x, int y) {
		super(x, y, RES, DMG, CICLOS, NAME, SHORTNA, COST);
	}

	public Nuez() {
		super(-1, -1, RES, DMG, CICLOS, INFONAME, SHORTNA, COST);
	}

	@Override
	public Plant parse(String plantName, int x, int y) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NAME) || plantName.equalsIgnoreCase(SHORTNA)) {
			p = new Nuez(x, y);
		}
		return p;
	}

	public void accion() {

	}
}
