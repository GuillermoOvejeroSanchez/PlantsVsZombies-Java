package elems;

public class Petacereza extends Plant {
	final static int COST = 50;
	final static int CICLOS = 2;
	final static int DMG = 10;
	final static int RES = 2;
	final static String INFONAME = "Peta[c]ereza";
	final static String NAME = "petacereza";
	final static String SHORTNA = "C";

	public Petacereza(int x, int y) {
		super(x, y, RES, DMG, CICLOS, NAME, SHORTNA, COST);
	}

	public Petacereza() {
		super(-1, -1, RES, DMG, CICLOS, INFONAME, SHORTNA, COST);
	}

	@Override
	public Plant parse(String plantName, int x, int y) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NAME) || plantName.equalsIgnoreCase(SHORTNA)) {
			p = new Petacereza(x, y);
		}
		return p;
	}

//Explota
	public void accion() {
//TODO accion Petacereza
	}

}
