package elems;

import src.Game;

public class Nuez extends Plant {

	public Nuez(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public Nuez() {
		inicializar();
	}

	private void inicializar() {
		cost = 50;
		res = 10;
		cycles = 0;
		nameShort = "N";
		name = "nuez";
		infoName = "[N]uez";
	}

	@Override
	public Plant parse(String plantName, int x, int y, Game game) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(name) || plantName.equalsIgnoreCase(nameShort)) {
			p = new Nuez(x, y, game);
		}
		return p;
	}

	public void accion() {

	}

}
