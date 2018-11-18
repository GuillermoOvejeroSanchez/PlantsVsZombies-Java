package elems;

import src.Game;

public class Sunflower extends Plant {

	final static int COST = 20;
	final static int CICLOS = 2;
	final static int DMG = 0;
	final static int RES = 1;
	final static String INFONAME = "[S]unflower";
	final static String NAME = "sunflower";
	final static String SHORTNA = "S";

	public Sunflower(int x, int y) {
		super(x, y, RES, DMG, CICLOS, NAME, SHORTNA, COST);
	}

	public Sunflower() {
		super(-1, -1, RES, DMG, CICLOS, INFONAME, SHORTNA, COST);
	}

	@Override
	public Plant parse(String plantName, int x, int y) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NAME) || plantName.equalsIgnoreCase(SHORTNA)) {
			p = new Sunflower(x, y);
		}
		return p;
	}

	@Override
	public String getShortName() {
		return SHORTNA;
	}

	// Gana Soles
	public void accion() {
		Game.modifySuncoins(10);
	}
}
